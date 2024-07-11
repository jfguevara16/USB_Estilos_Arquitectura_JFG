package com.example.agentbased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agentes")
public class AgentController {
	
	    @Autowired
	    private AgentService agentService;

	    @PostMapping
	    public Agent createAgent(@RequestParam String id, @RequestParam String name) {
	        return agentService.createAgent(id, name);
	    }

	    @GetMapping("/{id}")
	    public Agent getAgent(@PathVariable String id) {
	        return agentService.getAgent(id);
	    }

	    @PostMapping("/{id}/message")
	    public void sendMessage(@PathVariable String id, @RequestParam String message) {
	        agentService.sendMessageToAgent(id, message);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteAgent(@PathVariable String id) {
	        agentService.deleteAgent(id);
	    }

}
