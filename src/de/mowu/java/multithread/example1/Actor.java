package de.mowu.java.multithread.example1;

public class Actor extends Thread {
	@Override
	public void run() {
		System.out.println(getName() + " is an actor!");
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning){
			System.out.println("The " + (++count) + " show of " + getName());
			if(count == 100){
				keepRunning = false;
			}
			if(count % 10 == 0){
				try {
//					sleep 1 second
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("The show of " + getName() + " is over!");
	}
	
	public static void main(String[] args){
		Thread actor = new Actor();
		actor.setName("Mr.Thread");
		actor.start();
		
		Thread actressThread = new Thread(new Actress(), "Ms.Runnable");
		actressThread.start();
	}

}

class Actress implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is an actress!");
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning){
			System.out.println("The " + (++count) + " show of " + Thread.currentThread().getName());
			if(count == 100){
				keepRunning = false;
			}
			if(count % 10 == 0){
				try {
//					sleep 1 second
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("The show of " + Thread.currentThread().getName() + " is over!");
	}
	
}

