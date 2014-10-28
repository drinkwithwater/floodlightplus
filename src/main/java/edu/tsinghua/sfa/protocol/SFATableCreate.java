package edu.tsinghua.sfa.protocol;

import java.nio.ByteBuffer;

import org.openflow.protocol.OFMessage;
import org.openflow.protocol.OFType;

public class SFATableCreate extends OFMessage{
	protected byte sfaTableId;
	protected short priority;
	protected SFAStProperty stp;
	protected SFAAtProperty atp;
	protected SFASttProperty sttp;
	protected SFAEtProperty etp;
	@Override
	public void readFrom(ByteBuffer data){
		super.readFrom(data);
		if(stp==null) stp=new SFAStProperty();
		if(atp==null) atp=new SFAAtProperty();
		if(sttp==null) sttp=new SFASttProperty();
		if(etp==null) etp=new SFAEtProperty();

		this.sfaTableId=data.get();
		this.priority=data.getShort();

		this.stp.readFrom(data);
		this.atp.readFrom(data);
		this.sttp.readFrom(data);
		this.etp.readFrom(data);
	}
	@Override
	public void writeTo(ByteBuffer data){
		super.writeTo(data);
		if(stp==null) stp=new SFAStProperty();
		if(atp==null) atp=new SFAAtProperty();
		if(sttp==null) sttp=new SFASttProperty();
		if(etp==null) etp=new SFAEtProperty();

		data.put(this.sfaTableId);
		data.putShort(this.priority);

		this.stp.writeTo(data);
		this.atp.writeTo(data);
		this.sttp.writeTo(data);
		this.etp.writeTo(data);
	}

	public SFATableCreate(){
		super();
		this.type=OFType.SFA_TABLE_CREATE;
		
		this.sfaTableId=(byte)0;
		this.priority=0;
		this.stp=null;
		this.atp=null;
		this.sttp=null;
		this.etp=null;
	}

}
