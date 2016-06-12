package us.walid.paul;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	// WIDTH+HEIGHT+SCALE
	public static int scale = 3;
	public static int width = 300;
	public static int height = width / 16 * 9;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

	// Create Window + Dimensions test
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		frame = new JFrame();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (running) {
			update();
			render();
		}
	}

	public void update() {

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		Game game = new Game();

		game.frame.setResizable(false);
		game.frame.setTitle("Streetfighters");

		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);

		game.frame.setVisible(true);

		game.start();
	}

}
