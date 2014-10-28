package edu.tsinghua.sfa.protocol;

import java.nio.ByteBuffer;

public class SFASttEvent {
	protected SFASttEventParam param1=null;
	protected SFASttEventParam param2=null;
	protected byte op=0;
	protected byte index=0;

	public void readFrom(ByteBuffer data){
		if(param1==null) param1=new SFASttEventParam();
		if(param2==null) param1=new SFASttEventParam();
		this.param1.readFrom(data);
		this.param2.readFrom(data);
		this.op=data.get();
		this.index=data.get();
	}
	public void writeTo(ByteBuffer data){
		this.param1.writeTo(data);
		this.param2.writeTo(data);
		data.put(this.op);
		data.put(this.index);
	}
}
