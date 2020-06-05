package models.dxo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import models.dto.SignUpDto;

public class SignUpDxo {
	private SignUpDxo() {}
	
	public static SignUpDto convert(HttpServletRequest request) throws IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		return new SignUpDto(name, email);
	}
}
