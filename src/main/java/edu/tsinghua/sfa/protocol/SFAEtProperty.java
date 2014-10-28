package edu.tsinghua.sfa.protocol;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class SFAEtProperty {
	protected short eventNumber = 0;
	protected List<SFASttEvent> events = null;

	public void readFrom(ByteBuffer data) {
		this.eventNumber = data.getShort();
		this.events = new LinkedList<SFASttEvent>();
		for (int i = 0; i < eventNumber; i++) {
			SFASttEvent event = new SFASttEvent();
			event.readFrom(data);
			events.add(event);
		}
	}

	public void writeTo(ByteBuffer data) {
		data.putShort(this.eventNumber);
		if (this.events == null) {
			for (SFASttEvent event : events) {
				event.writeTo(data);
			}
		}
	}
}