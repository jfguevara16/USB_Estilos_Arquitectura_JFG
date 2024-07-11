package com.example.agentbased;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AgentService {
	
	private Map<String, Agent> agents = new HashMap<>();
    private Map<String, Thread> agentThreads = new HashMap<>();

    public Agent createAgent(String id, String name) {
        Agent agent = new Agent(id, name);
        Thread thread = new Thread(agent);
        agents.put(id, agent);
        agentThreads.put(id, thread);
        thread.start();
        return agent;
    }

    public Agent getAgent(String id) {
        return agents.get(id);
    }

    public void sendMessageToAgent(String id, String message) {
        Agent agent = agents.get(id);
        if (agent != null) {
            agent.sendMessage(message);
        }
    }

    public void deleteAgent(String id) {
        Agent agent = agents.remove(id);
        Thread thread = agentThreads.remove(id);
        if (agent != null) {
            agent.stop();
        }
        if (thread != null) {
            thread.interrupt();
        }
    }

}
