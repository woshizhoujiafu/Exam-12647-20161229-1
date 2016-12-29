package hand.Exam_12647_20161229_1;

import java.util.Date;
import java.util.Scanner;

import org.apache.ibatis.reflection.SystemMetaObject;

import hand.zjf.dto.ApplicationFactory;
import hand.zjf.entity.Film;
import hand.zjf.service.FilmOperationService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationFactory af = ApplicationFactory.getInstance();
        FilmOperationService fos = (FilmOperationService)af.getApplicationContext().getBean("filmOperationService");
        System.out.println("*****************************************************************");
        System.out.println("************************Context Start****************************");
       
        Film film = new Film();
        Scanner input = new Scanner(System.in);
        String choose;
        while(true){
        	System.out.println("***********************");
        	System.out.println("*根据提示请输入你的选择**");
        	System.out.println("*输入1录入Film信息******");
        	System.out.println("*输入0退出当前系统******");
        	System.out.println("***********************");
        	System.out.print("请输入你的选择:");
        	choose = input.nextLine();
        	
        	switch (choose) {
        	
		      case "1": System.out.println("*****************************************************************");
				        System.out.print("请输入电影名称(title):");
				        String title;
				        title = input.nextLine();
				        while(true){
				        	if(title.equals("")){
				        		System.out.print("请输入电影名称(title):");
				        		 title = input.nextLine();
				        	}else{
				        		break;
				        	}
				        }
				        
				        System.out.print("请输入电影名称(description):");
				        String description;
				        description = input.nextLine();
				        while(true){
				        	if(description.equals("")){
				        		System.out.print("请输入电影描述(description):");
				        		description = input.nextLine();
				        	}else{
				        		break;
				        	}
				        }
				        
				        System.out.print("请输入语言id(languageId):");
				        String language_id;
				        int languageId;
				        language_id = input.nextLine();
				        while(true){
				        	if(language_id.equals("")){
				        		System.out.print("请输入语言id(languageId):");
				        		language_id = input.nextLine();
				        	}else{
				        		try {
				        			try {
										languageId = Integer.parseInt(language_id);
										break;
									} catch (Exception e) {
										throw new RuntimeException("********************格式错误请输入数字******************");
									}     		
								} catch (RuntimeException e) {
									System.out.println(e.getMessage());
									language_id="";
								}		        					        		
				        	}
				        }
				        Date lastUpdate = new Date();
				        film.setTitle(title);
				        film.setDescription(description);
				        film.setLanguageId(Integer.parseInt(language_id));
				        film.setLastUpdate(lastUpdate);
				        
				        
				        try {
				        	fos.insertOneFilm(film);
				        	System.out.println("*****************************************************************");
				        	System.out.println("***********************Context Stop******************************");
				        	System.out.println("*****************************************************************");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
				        break;
		      case "0":System.out.println("*****************************************************************");
		               System.out.println("谢谢使用本系统");
		    	  	   System.exit(0); 
        	}
        
        }
        
    }
}
