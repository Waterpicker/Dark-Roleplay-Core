package net.dark_roleplay.core.modules.blueprints;

import java.nio.ByteBuffer;
import java.util.List;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;

public class BlueprintTessellator {

	private BufferBuilder buffer;

	public BlueprintTessellator(BufferBuilder buffer) {
		this.buffer = buffer;
		this.buffer.finishDrawing();
	}

	public void draw() {
		this.buffer.getByteBuffer().position(0);
		this.draw(this.buffer);
	}
	Tessellator tes;
	public void draw(BufferBuilder bufferBuilderIn) {
		if (bufferBuilderIn.getVertexCount() > 0) {
			VertexFormat vertexformat = bufferBuilderIn.getVertexFormat();
			int i = vertexformat.getSize();
			ByteBuffer bytebuffer = bufferBuilderIn.getByteBuffer();
			List<VertexFormatElement> list = vertexformat.getElements();

			for (int j = 0; j < list.size(); ++j) {
				VertexFormatElement vertexformatelement = list.get(j);
				VertexFormatElement.EnumUsage vertexformatelement$enumusage = vertexformatelement.getUsage();
				int k = vertexformatelement.getType().getGlConstant();
				int l = vertexformatelement.getIndex();
				bytebuffer.position(vertexformat.getOffset(j));

				// moved to VertexFormatElement.preDraw
				vertexformatelement.getUsage().preDraw(vertexformat, j, i, bytebuffer);
			}

			GlStateManager.glDrawArrays(bufferBuilderIn.getDrawMode(), 0, bufferBuilderIn.getVertexCount());
			int i1 = 0;

			for (int j1 = list.size(); i1 < j1; ++i1) {
				VertexFormatElement vertexformatelement1 = list.get(i1);
				VertexFormatElement.EnumUsage vertexformatelement$enumusage1 = vertexformatelement1.getUsage();
				int k1 = vertexformatelement1.getIndex();

				// moved to VertexFormatElement.postDraw
				vertexformatelement1.getUsage().postDraw(vertexformat, i1, i, bytebuffer);
			}
		}
	}
}
