/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.ballerinalang.model.types;

/**
 * This class contains various methods manipulate {@link BType}s in Ballerina.
 *
 * @since 0.8.0
 */
public class BTypes {
    public static BType typeInt = new BIntegerType(TypeConstants.INT_TNAME, null);
    public static BType typeFloat = new BFloatType(TypeConstants.FLOAT_TNAME, null);
    public static BType typeString = new BStringType(TypeConstants.STRING_TNAME, null);
    public static BType typeBoolean = new BBooleanType(TypeConstants.BOOLEAN_TNAME, null);
    public static BType typeBlob = new BBlobType(TypeConstants.BLOB_TNAME, null);
    public static BType typeXML = new BXMLType(TypeConstants.XML_TNAME, null);
    public static BType typeJSON = new BJSONType(TypeConstants.JSON_TNAME, null);
    public static BType typeDatatable = new BDataTableType(TypeConstants.DATATABLE_TNAME, null);
    public static BType typeAny = new BAnyType(TypeConstants.ANY_TNAME, null);
    public static BType typeType = new BTypeType(TypeConstants.TYPE_TNAME, null);
    public static BType typeMap = new BMapType(TypeConstants.MAP_TNAME, typeAny, null);
    public static BType typeConnector = new BConnectorType(TypeConstants.CONNECTOR_TNAME, null);
    public static BType typeNull = new BNullType(TypeConstants.NULL_TNAME, null);
    public static BType typeXMLAttributes = new BXMLAttributesType(TypeConstants.XML_ATTRIBUTES_TNAME, null);

    private BTypes() {
    }

    public static boolean isValueType(BType type) {
        if (type == BTypes.typeInt ||
                type == BTypes.typeFloat ||
                type == BTypes.typeString ||
                type == BTypes.typeBoolean ||
                type == BTypes.typeBlob) {
            return true;
        }

        return false;
    }

    public static BType getTypeFromName(String typeName) {
        switch (typeName) {
            case TypeConstants.JSON_TNAME:
                return typeJSON;
            case TypeConstants.XML_TNAME:
                return typeXML;
            case TypeConstants.MAP_TNAME:
                return typeMap;
            case TypeConstants.DATATABLE_TNAME:
                return typeDatatable;
            default:
                throw new IllegalStateException("Unknown type name");
        }
    }

}
