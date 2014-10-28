package edu.tsinghua.sfa.protocol;

import java.nio.ByteBuffer;

public class SFASttEntry {

	protected short state1=0;
	protected short state2=0;
	protected short index=0;

	public void readFrom(ByteBuffer data){
		this.state1=data.getShort();
		this.state2=data.getShort();
		this.index=data.getShort();
	}
	public void writeTo(ByteBuffer data){
		data.putShort(this.state1);
		data.putShort(this.state2);
		data.putShort(this.index);
	}

}
