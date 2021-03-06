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
package org.wso2.ballerinalang.programfile;

import java.util.Objects;

/**
 * {@code FunctionInfo} contains metadata of a Ballerina function entry in the program file.
 *
 * @since 0.87
 */
public class FunctionInfo extends CallableUnitInfo {

    public FunctionInfo(int pkgCPIndex, int funcNameCPIndex) {
        this.pkgNameCPIndex = pkgCPIndex;
        this.nameCPIndex = funcNameCPIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkgNameCPIndex, nameCPIndex);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FunctionInfo && pkgNameCPIndex == (((FunctionInfo) obj).pkgNameCPIndex)
                && nameCPIndex == (((FunctionInfo) obj).nameCPIndex);
    }
}
