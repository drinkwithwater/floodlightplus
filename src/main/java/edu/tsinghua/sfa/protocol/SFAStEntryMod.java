package edu.tsinghua.sfa.protocol;

import java.nio.ByteBuffer;

import org.openflow.protocol.OFMessage;
import org.openflow.protocol.OFType;

public class SFAStEntryMod extends OFMessage {
	//TODO
	public SFAStEntryMod(){
		super();
		this.type=OFType.SFA_ST_ENTRY_MOD;
	}

	public void readFrom(ByteBuffer data){
	}
	public void writeTo(ByteBuffer data){
	}
}
