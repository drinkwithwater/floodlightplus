package edu.tsinghua.sfa.protocol;

import java.nio.ByteBuffer;

public class SFAAtProperty {
	protected long bitmap=0;

	public void readFrom(ByteBuffer data){
		this.bitmap=data.getLong();
	}
	public void writeTo(ByteBuffer data){
		data.putLong(bitmap);
	}
}
