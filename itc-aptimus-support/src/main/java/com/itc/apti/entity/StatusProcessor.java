package com.itc.apti.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("StatusProcessor")
public class StatusProcessor implements Processor<String, List<Status>> {

	@Override
	public List<Status> get(String str) {
		List<Status> statusList = new ArrayList<Status>();
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Status status = new Status();
			status.setHostCanonicalName("Connonical-"+i);
			status.setHostIp("HostIP-"+i);
			status.setHostName("Hostname-"+i);
			
			statusList.add(status);
		}
		
		return statusList;
	}

	
	
	

}
