package renderer;

import Main.MainApp;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;
import static org.lwjgl.opengl.GL11.*;

public class Window {

	public long windowID;

	public void createWindow(int width, int height, String title) {
		boolean initState = GLFW.glfwInit();

		if(initState == false){
			throw  new IllegalStateException("Could not create GLFW");
		}

		windowID = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);

		if(windowID == MemoryUtil.NULL){
			throw new IllegalStateException("Can't make window");
		}

		GLFW.glfwMakeContextCurrent(windowID);
		GLFW.glfwSwapInterval(1);
		GLFW.glfwShowWindow(windowID);
		GL.createCapabilities();

		/*
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, MainApp.width, 0, MainApp.height, -1, 1);
		glMatrixMode(GL_MODELVIEW);

		glClearColor(0, 0, 0, 1);

		glDisable(GL_DEPTH_TEST);

		 */
	}

	public void updateWindow(){
		GLFW.glfwSwapBuffers(windowID);
		GLFW.glfwPollEvents();
		GLFW.glfwSwapInterval(1);
	}

	public void closeWindow(){
		GLFW.glfwDestroyWindow(windowID);
		GLFW.glfwTerminate();
	}

	public boolean shouldClose(){
		return GLFW.glfwWindowShouldClose(windowID);
	}
}
