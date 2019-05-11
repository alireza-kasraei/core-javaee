package com.sadad.web.acl;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_PERMISSIONS_PATH = "/WEB-INF/classes/permissions.json";
	private String permissionsFilePath;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		permissionsFilePath = config.getInitParameter("permissionsFilePath");
		if (permissionsFilePath == null || permissionsFilePath.isEmpty()) {
			permissionsFilePath = DEFAULT_PERMISSIONS_PATH;
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		InputStream permissionsStream = getServletContext().getResourceAsStream(permissionsFilePath);
		final ServletOutputStream outputStream = resp.getOutputStream();
		if (permissionsStream != null) {
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = (permissionsStream.read(buffer))) != -1) {
				outputStream.write(buffer, 0, len);
			}
			permissionsStream.close();
			outputStream.close();
		}
	}

}
