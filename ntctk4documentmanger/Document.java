/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4documentmanger;

/**
 *
 * @author Nathan
 */
public class Document 
{
    private String title;
    private String author;
    private String body;
    private int version;
    
    Document(String title, String author)
    {
       setTitle(title);
       setAuthor(author);
        version = 0;
    }
    
    Document(String title, String author, String body)
    {
        setTitle(title);
        setAuthor(author);
        setBody(body);
        version = 1;
    }
    
    void setTitle(String title)
    {
      this.title = title; 
      ++version;
    }
    
    void setAuthor(String author)
    {
        this.author = author;
    }
    
    void setBody(String body)
    {
        this.body = body;
        ++version;
    }
    
    String getTitle()
    {
        return title;
    }
    
    String getAuthor()
    {
        return author;
    }
    
    String getBody()
    {
        return body;
    }
    
    int getVersion()
    {
        return version;
    }
}
