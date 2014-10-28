package edu.tsinghua.sfa.protocol;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class SFASttProperty {
	protected short entryNumber = 0;
	protected List<SFASttEntry> entries = null;

	public void readFrom(ByteBuffer data) {
		this.entryNumber = data.getShort();
		this.entries = new LinkedList<SFASttEntry>();
		for (int i = 0; i < entryNumber; i++) {
			SFASttEntry entry = new SFASttEntry();
			entry.readFrom(data);
			entries.add(entry);
		}
	}

	public void writeTo(ByteBuffer data) {
		data.putShort(this.entryNumber);
		if (this.entries == null) {
			for (SFASttEntry entry : entries) {
				entry.writeTo(data);
			}
		}
	}
}
