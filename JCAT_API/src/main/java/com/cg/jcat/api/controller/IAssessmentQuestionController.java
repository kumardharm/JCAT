package com.cg.jcat.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jcat.api.dao.AssessmentQuestionModel;


@RestController
@RequestMapping("/assessmentQuestion")
public interface IAssessmentQuestionController {
	
	@GetMapping("/getAll")
	public List<AssessmentQuestionModel> getQuestions();
	
	@PostMapping("/createQuestion/{createdBy}")
	public void saveQuestions(@PathVariable String createdBy, @RequestBody AssessmentQuestionModel question);
	
	@PutMapping("/updateQuestion/{modifiedBy}")
	public void updateQuestion(@PathVariable String modifiedBy, @RequestBody AssessmentQuestionModel question);
	
	@DeleteMapping("/deleteQuestion/{userId}")
	public void deleteQuestion(@PathVariable int userId);

}
