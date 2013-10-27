package com.tech.rest.put.controller;

import java.io.StringReader;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tech.rest.put.model.EmployeeDetails;
import com.tech.rest.put.model.EmployeeList;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	private Jaxb2Marshaller jaxb2Mashaller;

	public void setJaxb2Mashaller(Jaxb2Marshaller jaxb2Mashaller) {
		this.jaxb2Mashaller = jaxb2Mashaller;
	}

	/**
	 * Provide string in request body
	 * 
	 * Url: http://localhost:8080/RestPutImpl/rest/employee/listAllEmployeeXML
	 * Type: PUT
	 * Body: <EMPLOYEELIST><EMPLOYEE><EMPLOYEE-ID>001</EMPLOYEE-ID><EMPLOYEE-NAME>eName1</EMPLOYEE-NAME></EMPLOYEE><EMPLOYEE><EMPLOYEE-ID>002</EMPLOYEE-ID><EMPLOYEE-NAME>eName2</EMPLOYEE-NAME></EMPLOYEE></EMPLOYEELIST> 
	 *  
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/listAllEmployeeXML")
	public ModelAndView listAllEmployeeXMLToObject(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		EmployeeList e = (EmployeeList) jaxb2Mashaller.unmarshal(source);
		List<EmployeeDetails> list = e.getEmployeeDetails();
		ModelAndView view = new ModelAndView("employeeDetails");
		view.addObject("employeeList", list);
		return view;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/listAllEmployeeJSON", headers="Accept=*/*")
	public ModelAndView listAllEmployeeJSONToObject(@RequestBody EmployeeDetails body) {
		ModelAndView view = new ModelAndView("employeeDetails");
		view.addObject("employeeList", body);
		return view;
	}

}
