import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.geom.*;

public class Pigs{
	public static final Color TRANSPARENT = Color.white;
	public static final Color FRONT_COLOR = Color.black;

	public static void main(String[] args){
	
		boolean noDelay = args.length == 1;
	
		AnimatedGifEncoder encoder = new AnimatedGifEncoder();
		//encoder.setTransparent(TRANSPARENT);
		encoder.start(System.out);
		encoder.setDelay(noDelay ? 50 : 1);
		for(int i=0; i<100; i+=(int)(Math.random()*20)){
			addMessage(encoder, i);
			sleep(noDelay ? 0 : 1000);
		}
		addMessage(encoder, 100);
		sleep(noDelay ? 0 : 1000);
		addMessage(encoder, "Done");
		encoder.finish();
	}
	
	public static void sleep(int delay){
		try{
			Thread.sleep(delay);
		}catch(Exception e){
			//
		}
	}
	
	public static void addMessage(AnimatedGifEncoder encoder, String message){
		encoder.addFrame(writeText(message, 64, 64));
		encoder.outFlush();
	}
	public static void addMessage(AnimatedGifEncoder encoder, int progress){
		encoder.addFrame(progress(progress, 64, 64));
		encoder.outFlush();
	}
	
	public static BufferedImage writeText(String text, int w, int h){
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.setColor(TRANSPARENT);
		g.fillRect(0, 0, w, h);
		drawCenteredString(text, w, h, (Graphics2D)g);
		return bi;
	}
	
	public static BufferedImage progress(int percent, int w, int h){
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.setColor(TRANSPARENT);
		g.fillRect(0, 0, w, h);
		drawCenteredProgressRing(percent, w, h, g);
		return bi;
	}
	public static void drawCenteredProgressRing(int progress, int w, int h, Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(FRONT_COLOR);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(8.0f));
		g2.draw(new Arc2D.Double(5, 5, w-10, h-10, 90, -progress/100f*360, Arc2D.OPEN));
		g2.setPaint(FRONT_COLOR);
		drawCenteredString(progress+"%", w, h, g2);
		g2.setPaint(TRANSPARENT);
	}
	
	public static void drawCenteredString(String s, int w, int h, Graphics2D g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s)) / 2;
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		g.setColor(FRONT_COLOR);
		g.drawString(s, x, y);
		g.setPaint(TRANSPARENT);
	}
}