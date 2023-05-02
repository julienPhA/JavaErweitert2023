package org.example;

public class Counter implements Runnable {
	private int from;
	private int to;
	private boolean stopped;
	private String threadName;
	private int sum;
	public Counter(int from, int to) {
		super();
		this.from = from;
		this.to = to;
		stopped = false;
	}
	@Override
	public void run() {
		threadName = Thread.currentThread().getName();
		for (int i = from; i < to; i++) {
			System.out.println("i = "+i+" on thread "+threadName);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sum = getSum() + i;
			if(stopped) {
				break;
			}
		}
		System.out.println("Thread "+threadName+" ends ");
	}
	public int getSum() {
		return sum;
	}
	void cancel() {
		stopped = true;
	}
}
