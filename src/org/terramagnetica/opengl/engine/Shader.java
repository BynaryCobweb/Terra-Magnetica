package org.terramagnetica.opengl.engine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.terramagnetica.ressources.RessourcesManager;

public class Shader {
	
	public enum ShaderType {
		VERTEX_SHADER(GL20.GL_VERTEX_SHADER),
		FRAGMENT_SHADER(GL20.GL_FRAGMENT_SHADER);
		
		public final int TYPE_ID;
		
		ShaderType(int typeID) {
			this.TYPE_ID = typeID;
		}
	}
	
	private ShaderType type;
	private int shaderID = 0;
	
	public static Shader loadInternalShader(String filename, ShaderType type) throws IOException, ShaderCompilationException {
		StringBuilder output = new StringBuilder(1024);
		InputStream stream = Shader.class.getResourceAsStream("../shaders/" + filename);
		
		if (stream == null) {
			throw new FileNotFoundException(filename + " is not an internal shader.");
		}
		
		RessourcesManager.readFileString(stream, output);
		
		try {
			return new Shader(output.toString(), type);
		}
		catch (ShaderCompilationException e) {
			throw new ShaderCompilationException(filename + " did not compile :\n" + e.getMessage());
		}
	}
	
	public Shader(String shaderCode, ShaderType type) throws ShaderCompilationException {
		this.type = type;
		this.shaderID = GL20.glCreateShader(type.TYPE_ID);
		
		if (this.shaderID == 0) {
			throw new RuntimeException("Impossible de cr�er des shaders. D�sol� on ne sait pas pourquoi.");
		}
		
		GL20.glShaderSource(this.shaderID, shaderCode);
		GL20.glCompileShader(this.shaderID);
		
		int compiled = GL20.glGetShaderi(this.shaderID, GL20.GL_COMPILE_STATUS);
		
		if (compiled == GL11.GL_FALSE) {
			String infoLog = GL20.glGetShaderInfoLog(this.shaderID, 1024);
			throw new ShaderCompilationException(infoLog);
		}
	}
	
	public int getShaderID() {
		return this.shaderID;
	}
	
	public void destroy() {
		finalize();
	}
	
	@Override
	protected void finalize() {
		GL20.glDeleteShader(this.shaderID);
	}
}