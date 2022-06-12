package renderer;

import models.Vao;
import org.lwjgl.opengl.GL11;

public class SimpleRenderer implements RendererInterface{

	private void prepare(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(.5f, .75f, 1f, 1);
	}

	public void render(Vao vao){
		prepare();
		vao.render();
	}

	@Override
	public void render() {
		System.out.println("not fully implemented");
	}
}
