/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.test.debugger;

import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.bvm.BLangVM;
import org.ballerinalang.util.codegen.ProgramFile;

/**
 * {@link DebuggerExecutor} represents executor class which runs the main program when debugging.
 *
 * @since 0.88
 */
public class DebuggerExecutor implements Runnable {
    private ProgramFile programFile;
    private Context bContext;

    public DebuggerExecutor(ProgramFile programFile, Context bContext) {
        this.programFile = programFile;
        this.bContext = bContext;
    }

    @Override
    public void run() {
        BLangVM bLangVM = new BLangVM(programFile);
        bContext.startTrackWorker();
        bContext.getDebugInfoHolder().getDebugSessionObserver().addContext(bContext);
        bContext.getDebugInfoHolder().waitTillDebuggeeResponds();
        bLangVM.run(bContext);
        bContext.await();
        bContext.getDebugInfoHolder().getDebugSessionObserver().notifyExit();
    }
}
