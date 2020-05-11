package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    response.setDateHeader("Expires", -1);
	        response.setHeader("Cache-Control", "no-cache");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Content-Type", "image/jpeg");
	        BufferedImage image = new BufferedImage(120, 40,
	                BufferedImage.TYPE_INT_BGR);

	        Graphics g = image.getGraphics();

	        g.setColor(Color.lightGray);
	        g.fillRect(0, 0, 120, 40);
	        String checkcode = "";

	        for(int i=0;i<4;i++){
	            g.setColor(Color.black);
	            g.setFont(generateFont());
	            String str = generateStr();
	            checkcode += str;
	            g.drawString(str,25*i,25);
	        }

	        for(int i=0;i<100;i++){
	            Random random = new Random();
	            int x = random.nextInt(120);
	            int y = random.nextInt(40);
	            g.setColor(generateColor());
	            g.fillOval(x, y, 2, 2);
	        }
	        for(int i=0;i<5;i++){
	            Random random = new Random();
	            int x1 = random.nextInt(120);
	            int y1 = random.nextInt(40);
	            int x2 = random.nextInt(120);
	            int y2 = random.nextInt(40);
	            g.setColor(generateColor());
	            g.drawLine(x1, y1, x2, y2);
	        }
	        request.getSession().setAttribute("checkcode", checkcode.toLowerCase());

	        ImageIO.write(image, "jpeg", response.getOutputStream());
	        

	    }

	    public Font generateFont() {
	        String[] font_names = new String[] { "Broadway", "Footlight MT Light", "Sitka Text","Colonna MT"};
	        int[] font_styles = new int[]{Font.BOLD, Font.ITALIC, Font.BOLD|Font.ITALIC};

	        Random random = new Random();
	        int name_index = random.nextInt(font_names.length);
	        int style_index = random.nextInt(font_styles.length);

	        return new Font(font_names[name_index],font_styles[style_index],28);
	    }

	    public Color generateColor() {
	        Random random = new Random();
	        return new Color(random.nextInt(256), random.nextInt(256),
	                random.nextInt(256));
	    }

	    public String generateStr() {
	        String[] nums = new String[62];
	        for (int i = 0; i < 10; i++) {
	            nums[i] = String.valueOf(i);
	        }
	        for (int i = 65; i < 91; i++) {
	            nums[i - 55] = Character.toString((char) i);
	        }
	        for (int i = 97; i < 123; i++) {
	            nums[i - 61] = Character.toString((char) i);
	        }
	        Random random = new Random();
	        int index = random.nextInt(62);
	        return nums[index];
	    }
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			this.doPost(request, response);
		}

}