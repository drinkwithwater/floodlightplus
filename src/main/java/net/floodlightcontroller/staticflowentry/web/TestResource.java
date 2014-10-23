/**
*    Copyright 2011, Big Switch Networks, Inc.
*    Originally created by David Erickson, Stanford University
*
*    Licensed under the Apache License, Version 2.0 (the "License"); you may
*    not use this file except in compliance with the License. You may obtain
*    a copy of the License at
*
*         http://www.apache.org/licenses/LICENSE-2.0
*
*    Unless required by applicable law or agreed to in writing, software
*    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
*    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
*    License for the specific language governing permissions and limitations
*    under the License.
**/

package net.floodlightcontroller.staticflowentry.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.floodlightcontroller.core.annotations.LogMessageCategory;
import net.floodlightcontroller.core.annotations.LogMessageDoc;
import net.floodlightcontroller.staticflowentry.StaticFlowEntries;
import net.floodlightcontroller.staticflowentry.StaticFlowEntryPusher;
import net.floodlightcontroller.storage.IStorageSourceService;

/**
 * Pushes a static flow entry to the storage source
 * @author alexreimers
 *
 */
@LogMessageCategory("Static Flow Pusher")
public class TestResource extends ServerResource {
    protected static Logger log = LoggerFactory.getLogger(TestResource.class);
    @Get
    public String test() {
        IStorageSourceService storageSource =
                (IStorageSourceService)getContext().getAttributes().
                    get(IStorageSourceService.class.getCanonicalName());

        Map<String, Object> rowValues=new HashMap<String, Object>();
        rowValues.put(StaticFlowEntryPusher.COLUMN_NAME,"1");
        rowValues.put(StaticFlowEntryPusher.COLUMN_SWITCH, "00:00:00:00:00:00:02:00");
//        rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "output="+2);
        rowValues.put(StaticFlowEntryPusher.COLUMN_INSTRUCTIONS, "not used");
        rowValues.put(StaticFlowEntryPusher.COLUMN_PRIORITY,"3");
        rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIVE,"true");
        rowValues.put(StaticFlowEntryPusher.COLUMN_IN_PORT,Integer.toString(1));
        rowValues.put(StaticFlowEntryPusher.COLUMN_DL_TYPE,"0x0800");
        //rowValues.put(StaticFlowEntryPusher.COLUMN_DL_SRC,"00:00:00:00:00:00:00:01");
        //rowValues.put(StaticFlowEntryPusher.COLUMN_DL_DST,"00:00:00:00:00:00:00:02");
        rowValues.put(StaticFlowEntryPusher.COLUMN_NW_SRC,"10.0.0.1");
        rowValues.put(StaticFlowEntryPusher.COLUMN_NW_DST,"10.0.0.2");

        storageSource.insertRowAsync(StaticFlowEntryPusher.TABLE_NAME, rowValues);


        return rowValues.toString();
        		
    }
}
