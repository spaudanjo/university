package syncFramework.process;

import vsFramework.Channel;
import vsFramework.Message;

public abstract class AbstractWork implements Work{
	protected Channel next,last;
	protected Message message,received;
	
	public AbstractWork(){
	}
	
	public AbstractWork(Channel next, Channel last){
		this.setNext(next);
		this.setLast(last);
	}
	
	public void setNext(Channel channel){
		this.next = channel;
	}
	
	public void setLast(Channel channel){
		this.last = channel;
	}
	
	
	@Override
	public void sendPhase() {
		this.next.send(message);
	}

	@Override
	public void recvPhase() {
		this.received = this.last.recv();
	}
}
