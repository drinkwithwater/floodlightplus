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
    public Map<String,Object> dosth(int num){
        Map<String, Object> rowValues=new HashMap<String, Object>();
        rowValues.put(StaticFlowEntryPusher.COLUMN_NAME,"1");
        rowValues.put(StaticFlowEntryPusher.COLUMN_SWITCH, "00:00:00:00:00:00:02:00");
        rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "dec-ip-ttl");
//        rowValues.put(StaticFlowEntryPusher.COLUMN_INSTRUCTIONS, "not used");
        rowValues.put(StaticFlowEntryPusher.COLUMN_PRIORITY,"3");
        rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIVE,"true");
        rowValues.put(StaticFlowEntryPusher.COLUMN_IN_PORT,Integer.toString(1));
        rowValues.put(StaticFlowEntryPusher.COLUMN_DL_TYPE,"0x0800");
        //rowValues.put(StaticFlowEntryPusher.COLUMN_DL_SRC,"00:00:00:00:00:00:00:01");
        //rowValues.put(StaticFlowEntryPusher.COLUMN_DL_DST,"00:00:00:00:00:00:00:02");
        rowValues.put(StaticFlowEntryPusher.COLUMN_NW_SRC,"10.0.0.1");
        rowValues.put(StaticFlowEntryPusher.COLUMN_NW_DST,"10.0.0.2");

        return rowValues;
        /*
        IStorageSourceService storageSource =
                (IStorageSourceService)getContext().getAttributes().
                    get(IStorageSourceService.class.getCanonicalName());

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<1;i++){
                Map<String,Object> rowValues=dosth(i);
                storageSource.insertRowAsync(StaticFlowEntryPusher.TABLE_NAME, rowValues);
                sb.append(rowValues.toString());
        }
        return sb.toString();*/
    }
    public static int dosthNum=10;
    public String dosth0(){
        IStorageSourceService storageSource =
                (IStorageSourceService)getContext().getAttributes().
                    get(IStorageSourceService.class.getCanonicalName());
    	for(int i=1;i<=dosthNum;i++){
    			String iFormat=""+i;
    			if(i==10) iFormat="10";
                Map<String, Object> rowValues=new HashMap<String, Object>();
                rowValues.put(StaticFlowEntryPusher.COLUMN_NAME,"1to10-"+i);
                rowValues.put(StaticFlowEntryPusher.COLUMN_SWITCH, "00:00:00:00:00:00:00:"+iFormat);
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "output="+2);
                rowValues.put(StaticFlowEntryPusher.COLUMN_PRIORITY,"3");
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIVE,"true");
                rowValues.put(StaticFlowEntryPusher.COLUMN_IN_PORT,"1");
                rowValues.put(StaticFlowEntryPusher.COLUMN_DL_TYPE,"0x0800");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_SRC,"10.0.0.1");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_DST,"10.0.0.10");
                storageSource.insertRowAsync(StaticFlowEntryPusher.TABLE_NAME, rowValues);
    	}
    	for(int i=1;i<=dosthNum;i++){
    			String iFormat=""+i;
    			if(i==10) iFormat="10";
                Map<String, Object> rowValues=new HashMap<String, Object>();
                rowValues.put(StaticFlowEntryPusher.COLUMN_NAME,"10to1-"+i);
                rowValues.put(StaticFlowEntryPusher.COLUMN_SWITCH, "00:00:00:00:00:00:00:"+iFormat);
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "output="+1);
                rowValues.put(StaticFlowEntryPusher.COLUMN_PRIORITY,"3");
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIVE,"true");
                rowValues.put(StaticFlowEntryPusher.COLUMN_IN_PORT,"2");
                rowValues.put(StaticFlowEntryPusher.COLUMN_DL_TYPE,"0x0800");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_SRC,"10.0.0.10");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_DST,"10.0.0.1");
                storageSource.insertRowAsync(StaticFlowEntryPusher.TABLE_NAME, rowValues);
    	}
    	return "success flow without dec-ip-ttl";
    }
    public String dosth1(){
        IStorageSourceService storageSource =
                (IStorageSourceService)getContext().getAttributes().
                    get(IStorageSourceService.class.getCanonicalName());
    	for(int i=1;i<=dosthNum;i++){
    			String iFormat=""+i;
    			if(i==10) iFormat="10";
                Map<String, Object> rowValues=new HashMap<String, Object>();
                rowValues.put(StaticFlowEntryPusher.COLUMN_NAME,"1to10-"+i);
                rowValues.put(StaticFlowEntryPusher.COLUMN_SWITCH, "00:00:00:00:00:00:00:"+iFormat);
                rowValues.put(StaticFlowEntryPusher.COLUMN_PRIORITY,"3");
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIVE,"true");
                rowValues.put(StaticFlowEntryPusher.COLUMN_IN_PORT,"1");
                rowValues.put(StaticFlowEntryPusher.COLUMN_DL_TYPE,"0x0800");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_SRC,"10.0.0.1");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_DST,"10.0.0.10");

                if(i==dosthNum){
                        rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "dec-ip-ttl,set-dst-mac=12:34:56:00:00:10,output=2");
                }else{
                        rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "dec-ip-ttl,set-dst-mac=00:00:00:00:00:01,output=2");
                }
                storageSource.insertRowAsync(StaticFlowEntryPusher.TABLE_NAME, rowValues);
    	}
    	for(int i=1;i<=dosthNum;i++){
    			String iFormat=""+i;
    			if(i==10) iFormat="10";
                Map<String, Object> rowValues=new HashMap<String, Object>();
                rowValues.put(StaticFlowEntryPusher.COLUMN_NAME,"10to1-"+i);
                rowValues.put(StaticFlowEntryPusher.COLUMN_SWITCH, "00:00:00:00:00:00:00:"+iFormat);
                rowValues.put(StaticFlowEntryPusher.COLUMN_PRIORITY,"3");
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIVE,"true");
                rowValues.put(StaticFlowEntryPusher.COLUMN_IN_PORT,"2");
                rowValues.put(StaticFlowEntryPusher.COLUMN_DL_TYPE,"0x0800");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_SRC,"10.0.0.10");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_DST,"10.0.0.1");
                if(i==1){
                        rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "dec-ip-ttl,set-dst-mac=12:34:56:00:00:01,output=1");
                }else{
                        rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "dec-ip-ttl,set-dst-mac=00:00:00:00:00:01,output=1");
                }
                storageSource.insertRowAsync(StaticFlowEntryPusher.TABLE_NAME, rowValues);
    	}
    	return "success flow with dec-ip-ttl";
    }

    public String dosth2(){
        IStorageSourceService storageSource =
                (IStorageSourceService)getContext().getAttributes().
                    get(IStorageSourceService.class.getCanonicalName());
    	for(int i=1;i<=dosthNum;i++){
    			String iFormat=""+i;
    			if(i==10) iFormat="10";
                Map<String, Object> rowValues=new HashMap<String, Object>();
                rowValues.put(StaticFlowEntryPusher.COLUMN_NAME,"1to10-"+i);
                rowValues.put(StaticFlowEntryPusher.COLUMN_SWITCH, "00:00:00:00:00:00:00:"+iFormat);
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "dec-ip-ttl");
                rowValues.put(StaticFlowEntryPusher.COLUMN_PRIORITY,"3");
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIVE,"true");
                rowValues.put(StaticFlowEntryPusher.COLUMN_IN_PORT,"1");
                rowValues.put(StaticFlowEntryPusher.COLUMN_DL_TYPE,"0x0800");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_SRC,"10.0.0.1");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_DST,"10.0.0.10");
                storageSource.insertRowAsync(StaticFlowEntryPusher.TABLE_NAME, rowValues);
    	}
    	for(int i=1;i<=dosthNum;i++){
    			String iFormat=""+i;
    			if(i==10) iFormat="10";
                Map<String, Object> rowValues=new HashMap<String, Object>();
                rowValues.put(StaticFlowEntryPusher.COLUMN_NAME,"10to1-"+i);
                rowValues.put(StaticFlowEntryPusher.COLUMN_SWITCH, "00:00:00:00:00:00:00:"+iFormat);
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIONS, "dec-ip-ttl");
                rowValues.put(StaticFlowEntryPusher.COLUMN_PRIORITY,"3");
                rowValues.put(StaticFlowEntryPusher.COLUMN_ACTIVE,"true");
                rowValues.put(StaticFlowEntryPusher.COLUMN_IN_PORT,"2");
                rowValues.put(StaticFlowEntryPusher.COLUMN_DL_TYPE,"0x0800");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_SRC,"10.0.0.10");
                rowValues.put(StaticFlowEntryPusher.COLUMN_NW_DST,"10.0.0.1");
                storageSource.insertRowAsync(StaticFlowEntryPusher.TABLE_NAME, rowValues);
    	}
    	return "success flow with dec-ip-ttl without output";
    }
    @Get("json")
    public String test() {
        String arg = (String) getRequestAttributes().get("arg");
        if(arg==null){
        	return "no arg do nothing";
        }
        if(arg.equals("1")){
        	return dosth1();
        }else if(arg.equals("0")){
        	return dosth0();
        }else if(arg.equals("2")){
        	return dosth2();
        }
    	return "do nothing";
    }
}
