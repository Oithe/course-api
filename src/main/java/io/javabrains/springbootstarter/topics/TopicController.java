package io.javabrains.springbootstarter.topics;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	public List<Topic>geALLTopics() {
		return Arrays.asList(
				new Topic("spring", "Spring Framework", "Spring Framework Description"),
				new Topic("java", "Core Java", "Core Java Description"),
				new Topic("javascript", "JavaScript", "JavaScript Description")
				);
	}
	@RequestMapping(value = "/addtopic", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("topic")Topic topic, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", topic.getName());
        model.addAttribute("description", topic.getDescription());
        model.addAttribute("id", topic.getId());
        return "The id is "+ topic.getId() + ". Name is: " + topic.getName() + " and it is described as: " + topic.getDescription() +".";
    }
}
