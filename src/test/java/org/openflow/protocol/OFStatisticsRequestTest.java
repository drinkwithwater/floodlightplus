/**
*    Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior
*    University
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

package org.openflow.protocol;

import java.util.List;

import junit.framework.TestCase;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.openflow.protocol.factory.BasicFactory;
import org.openflow.protocol.factory.OFMessageFactory;
import org.openflow.protocol.multipart.OFFlowStatisticsRequest;
import org.openflow.protocol.multipart.OFMultipartDataType;
import org.openflow.protocol.multipart.OFVendorStatistics;
import org.openflow.util.OFTestCase;

public class OFMultipartRequestTest extends OFTestCase {
    public void testOFFlowStatisticsRequest() throws Exception {
        byte[] packet = new byte[] { 0x01, 0x10, 0x00, 0x38, 0x00, 0x00, 0x00,
                0x16, 0x00, 0x01, 0x00, 0x00, (byte) 0xff, (byte) 0xff,
                (byte) 0xff, (byte) 0xff, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                (byte) 0xff, 0x00, (byte) 0xff, (byte) 0xff };

        OFMessageFactory factory = BasicFactory.getInstance();
        ChannelBuffer packetBuf = ChannelBuffers.wrappedBuffer(packet);
        List<OFMessage> msg = factory.parseMessage(packetBuf);
        TestCase.assertNotNull(msg);
        TestCase.assertEquals(msg.size(), 1);
        TestCase.assertTrue(msg.get(0) instanceof OFMultipartRequest);
        OFMultipartRequest sr = (OFMultipartRequest) msg.get(0);
        TestCase.assertEquals(OFMultipartDataType.FLOW, sr.getStatisticType());
        TestCase.assertEquals(1, sr.getMultipartData().size());
        TestCase.assertTrue(sr.getMultipartData().get(0) instanceof OFFlowStatisticsRequest);
    }

    public void testOFMultipartRequestVendor() throws Exception {
        byte[] packet = new byte[] { 0x01, 0x10, 0x00, 0x50, 0x00, 0x00, 0x00,
                0x63, (byte) 0xff, (byte) 0xff, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x4c, 0x00, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x01, 0x00, 0x38, 0x00, 0x00, 0x00, 0x00, 0x00, 0x30, 0x20,
                (byte) 0xe0, 0x00, 0x11, 0x00, 0x0c, 0x29, (byte) 0xc5,
                (byte) 0x95, 0x57, 0x02, 0x25, 0x5c, (byte) 0xca, 0x00, 0x02,
                (byte) 0xff, (byte) 0xff, 0x00, 0x00, 0x08, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x2d, 0x00, 0x50, 0x04,
                0x00, 0x00, 0x00, 0x00, (byte) 0xff, 0x00, 0x00, 0x00,
                (byte) 0xff, (byte) 0xff, 0x4e, 0x20 };

        OFMessageFactory factory = BasicFactory.getInstance();
        ChannelBuffer packetBuf = ChannelBuffers.wrappedBuffer(packet);
        List<OFMessage> msg = factory.parseMessage(packetBuf);
        TestCase.assertNotNull(msg);
        TestCase.assertEquals(msg.size(), 1);
        TestCase.assertTrue(msg.get(0) instanceof OFMultipartRequest);
        OFMultipartRequest sr = (OFMultipartRequest) msg.get(0);
        TestCase.assertEquals(OFMultipartDataType.VENDOR, sr.getStatisticType());
        TestCase.assertEquals(1, sr.getMultipartData().size());
        TestCase.assertTrue(sr.getMultipartData().get(0) instanceof OFVendorStatistics);
        TestCase.assertEquals(68, ((OFVendorStatistics)sr.getMultipartData().get(0)).getLength());
    }
}
