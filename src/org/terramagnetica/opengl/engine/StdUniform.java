package org.terramagnetica.opengl.engine;

public interface StdUniform {
	
	String USE_TEXTURES = "useTextures";
	String USE_LIGHTS = "useLights";
	String USE_COLOR = "useColor";
	
	String TEXTURE_0 = "tex0";
	
	public interface View {
		String PROJECTION_MATRIX = "view.projection";
		String CAMERA_MATRIX = "view.camera";
		String MODEL_MATRIX = "view.model";
		String CAMERA_POSITION = "view.cameraPosition";
	}
	
	public interface Light {
		int MAX_LIGHT = 10;
		
		String ACTIVATED = "light[%d].activated";
		String TYPE = "light[%d].type";
		String POSITION = "light[%d].position";
		String AMBIENT = "light[%d].ambient";
		String DIFFUSE = "light[%d].diffuse";
		String SPECULAR = "light[%d].specular";
		String ATTENUATION = "light[%d].attenuation";
	}
	
	public interface Material {
		String AMBIENT = "material.ambient";
		String DIFFUSE = "material.diffuse";
		String SPECULAR = "material.specular";
		String SPECULAR_INTENSITY = "material.specularIntensity";
		String SHININESS = "material.shininess";
	}
}
