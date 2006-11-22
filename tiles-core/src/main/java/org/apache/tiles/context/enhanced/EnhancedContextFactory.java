/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.tiles.context.enhanced;

import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.context.BasicTilesContextFactory;

import javax.servlet.jsp.PageContext;

public class EnhancedContextFactory extends BasicTilesContextFactory {

    public TilesApplicationContext createApplicationContext(Object context) {
        TilesApplicationContext root = super.createApplicationContext(context);
        return new EnhancedTilesApplicationContext(root);
    }


    public TilesRequestContext createRequestContext(TilesApplicationContext context, Object request, Object response) {
        if (context instanceof EnhancedTilesApplicationContext) {
            context = ((EnhancedTilesApplicationContext) context).getRootContext();
        }
        return super.createRequestContext(context, request, response);
    }

    public TilesRequestContext createRequestContext(TilesApplicationContext context, PageContext pageContext) {
        if (context instanceof EnhancedTilesApplicationContext) {
            context = ((EnhancedTilesApplicationContext) context).getRootContext();
        }
        return super.createRequestContext(context, pageContext);
    }
}