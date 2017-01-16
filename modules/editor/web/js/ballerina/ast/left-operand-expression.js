/**
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
define(['lodash', './statement'], function(_, Statement){

    /**
     * Constructor for LeftOperandExpression
     * @param {Object} args - Arguments to create the LeftOperandExpression
     * @constructor
     */
    var LeftOperandExpression = function (args) {
        Statement.call(this, 'LeftOperandExpression');
        this.variable_reference_name = undefined;
    };

    LeftOperandExpression.prototype = Object.create(Statement.prototype);
    LeftOperandExpression.prototype.constructor = LeftOperandExpression;

    /**
     * Get Variable Reference Name
     * @returns {undefined|string}
     */
    LeftOperandExpression.prototype.getVariableReferenceName = function () {
        return this.variable_reference_name;
    };

    /**
     * Set Variable Reference Name
     * @param {string} variableRefName
     */
    LeftOperandExpression.prototype.setVariableReferenceName = function (variableRefName) {
        this.variable_reference_name = variableRefName;
    };

    /**
     * setting parameters from json
     * @param jsonNode
     */
    LeftOperandExpression.prototype.initFromJson = function (jsonNode) {
        var self = this;
        _.each(jsonNode.children, function (childNode) {
            // TODO: Handle this Properly
            if (childNode.type === 'variable_reference_expression') {
                self.setVariableReferenceName(childNode.variable_reference_name);
            } else {
                var child = self.getFactory().createFromJson(childNode);
                self.addChild(child);
                child.initFromJson(childNode);
            }
        });
    };

    return LeftOperandExpression;
});