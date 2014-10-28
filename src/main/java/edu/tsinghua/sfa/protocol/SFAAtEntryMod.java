package edu.tsinghua.sfa.protocol;

import java.nio.ByteBuffer;

import org.openflow.protocol.OFMessage;
import org.openflow.protocol.OFType;

public class SFAAtEntryMod extends OFMessage {
	//TODO
	public void readFrom(ByteBuffer data){
	}
	public void writeTo(ByteBuffer data){
	}

	public SFAAtEntryMod(){
		super();
		this.type=OFType.SFA_AT_ENTRY_MOD;
	}

}
