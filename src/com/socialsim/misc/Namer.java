package com.socialsim.misc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



public class Namer 
{

	/**
	 * @param args
	 */
	private static ArrayList<String> ds_list_create()
	{
		ArrayList<String> al = new ArrayList<String>();
		return al;
	}
	
	private static void ds_list_add(ArrayList<String> als, String str)
	{
		als.add(str);
	}
	
	private static HashMap<String , ArrayList<String>> ds_map_createsa()
	{
		HashMap<String , ArrayList<String>> hm = new HashMap<String , ArrayList<String>>();
		return hm;
	}
	
	private static void ds_map_addsa(HashMap<String , ArrayList<String>> hm , String str , ArrayList<String> al)
	{
		hm.put(str, al);
	}
	
	private static HashMap<String , Integer> ds_map_createsi()
	{
		HashMap<String , Integer> hm = new HashMap<String , Integer>();
		return hm;
	}
	
	private static void ds_map_addsi(HashMap<String , Integer> hm , String str , Integer i)
	{
		hm.put(str, i);
	}
	
	private static int irandom_range(int a,int b)
	{
		Random r = new Random();
		int i = r.nextInt(b - a + 1) + a;
		return i;
	}
	
	private static String ds_list_find_value(ArrayList<String> al, Integer i)
	{
		return al.get(i);
	}
	
	private static String sub(String str, int i)
	{
		char c = str.charAt(i-1);
		return Character.toString(c);
	}
	
	private static ArrayList<String> ds_map_find_valuesa(HashMap<String,ArrayList<String>> hm, String str)
	{
		return hm.get(str);
	}
	
	private static Integer ds_map_find_valuesi(HashMap<String,Integer> hm, String str)
	{
		return hm.get(str);
	}
	
	private static Integer ds_list_size(ArrayList<String> al)
	{
		return al.size();
	}
	
	HashMap<String , Integer> prob=ds_map_createsi();
	ArrayList<String> alphabet=ds_list_create();
	HashMap<String , ArrayList<String>> letters=ds_map_createsa();
	ArrayList<String> z=ds_list_create();
	ArrayList<String> yy=ds_list_create();
	ArrayList<String> xx=ds_list_create();
	ArrayList<String> w=ds_list_create();
	ArrayList<String> v=ds_list_create();
	ArrayList<String> u=ds_list_create();
	ArrayList<String> t=ds_list_create();
	ArrayList<String> s=ds_list_create();
	ArrayList<String> r=ds_list_create();
	ArrayList<String> q=ds_list_create();
	ArrayList<String> p=ds_list_create();
	ArrayList<String> o=ds_list_create();
	ArrayList<String> n=ds_list_create();
	ArrayList<String> m=ds_list_create();
	ArrayList<String> l=ds_list_create();
	ArrayList<String> k=ds_list_create();
	ArrayList<String> j=ds_list_create();
	ArrayList<String> i=ds_list_create();
	ArrayList<String> h=ds_list_create();
	ArrayList<String> g=ds_list_create();
	ArrayList<String> f=ds_list_create();
	ArrayList<String> e=ds_list_create();
	ArrayList<String> d=ds_list_create();
	ArrayList<String> c=ds_list_create();
	ArrayList<String> b=ds_list_create();
	ArrayList<String> a=ds_list_create();
	
	public Namer() 
	{
		/*
		 *  Each letter has its own list full of two-letter combos. Each letter combo has a 
		 *  six-letter/symbol code defining how it acts. The code goes as follows:
		 *  list name: first letter of the combo. (any letter a-z)
		 *  char1:     second letter of the combo. (any letter a-z)
		 *  char2:     Vowel/Consonant status of second letter. ('.' = cons; ',' = vowel)
		 *  char3:     Whether or not a word can end with this combo. ('?' = yes; '-' = never; '!'=always)
		 *  char4:     Whether it must be preceded by vowel, cons, or either. ('.' = cons; ',' = vowel; '=' = either)
		 *  char5:     Whether a vowel, cons, or either can come next. ('.' = cons; ',' = vowel; '*' = either)
		 *  char6:     Whether or not it can begin a word. ('y' = yes; 'n' = no)
		 */
			  ds_list_add(a,"b.?=*y");
			  ds_list_add(a,"c.-=*y");
			  ds_list_add(a,"d.?=*y");
			  ds_list_add(a,"f.-=*y");
			  ds_list_add(a,"g.?=*y");
			  ds_list_add(a,"h.?=,y");
			  ds_list_add(a,"i,-..y");
			  ds_list_add(a,"j.-=,y");
			  ds_list_add(a,"k.-=,y");
			  ds_list_add(a,"l.?=*y");
			  ds_list_add(a,"m.?=*y");
			  ds_list_add(a,"n.?=*y");
			  ds_list_add(a,"p.?=*y");
			  ds_list_add(a,"q.-=,y");
			  ds_list_add(a,"r.?=*y");
			  ds_list_add(a,"s.?=.y");
			  ds_list_add(a,"t.?=*y");
			  ds_list_add(a,"u,-..y");
			  ds_list_add(a,"v.-=*y");
			  ds_list_add(a,"w.?.*y");
			  ds_list_add(a,"x.?=*y");
			  ds_list_add(a,"yy?.,y");
			  ds_list_add(a,"z.?=*y");
			 
			  
			  ds_list_add(b,"a,?=*y");
			  ds_list_add(b,"e,?=*y");
			  ds_list_add(b,"g.-,,n");
			  ds_list_add(b,"i,-=*y");
			  ds_list_add(b,"j.-,,n");
			  ds_list_add(b,"l.-,,y");
			  ds_list_add(b,"o,?=*y");
			  ds_list_add(b,"r.-=*y");
			  ds_list_add(b,"u,-=*y");
			  ds_list_add(b,"w.-=,n");
			  ds_list_add(b,"yy!=*n");
			 
			  
			  ds_list_add(c,"a,?=*y");
			  ds_list_add(c,"e,?=*y");
			  ds_list_add(c,"h.?=,y");
			  ds_list_add(c,"i,-=.y");
			  ds_list_add(c,"k.?,*n");
			  ds_list_add(c,"l.-=,y");
			  ds_list_add(c,"o,?=*y");
			  ds_list_add(c,"r.-=*y");
			  ds_list_add(c,"t.?,,n");
			  ds_list_add(c,"u,-=*y");
			  ds_list_add(c,"yy!=*n");
			
			  
			  ds_list_add(d,"a,?=*y");
			  ds_list_add(d,"e,,=*y");
			  ds_list_add(d,"g.-,,n");
			  ds_list_add(d,"i,-=*y");
			  ds_list_add(d,"l.-,,n");
			  ds_list_add(d,"o,?=*y");
			  ds_list_add(d,"r.-=,y");
			  ds_list_add(d,"u,-=*y");
			  ds_list_add(d,"w.-=,y");
			  ds_list_add(d,"yy!=*n");
			 
			  
			  ds_list_add(e,"a,?..y");
			  ds_list_add(e,"b.?=*y");
			  ds_list_add(e,"c.-=*y");
			  ds_list_add(e,"e,?..y");
			  ds_list_add(e,"f.-=*y");
			  ds_list_add(e,"g.?=*y");
			  ds_list_add(e,"h.?=*y");
			  ds_list_add(e,"l.?=*y");
			  ds_list_add(e,"m.?=*y");
			  ds_list_add(e,"n.?=*y");
			  ds_list_add(e,"o,?..y");
			  ds_list_add(e,"p.?=*y");
			  ds_list_add(e,"q.-=*y");
			  ds_list_add(e,"r.?=*y");
			  ds_list_add(e,"s.?=*y");
			  ds_list_add(e,"t.?=*y");
			  ds_list_add(e,"w.?.*y");
			  ds_list_add(e,"x.?=*y");
			  ds_list_add(e,"yy?.,y");
			  ds_list_add(e,"z.?=*y");
			 
			  
			  ds_list_add(f,"a,-=*y");
			  ds_list_add(f,"e,,=*y");
			  ds_list_add(f,"f.?,*n");
			  ds_list_add(f,"i,-=*y");
			  ds_list_add(f,"l.-=*y");
			  ds_list_add(f,"o,?=*y");
			  ds_list_add(f,"r.-=*y");
			  ds_list_add(f,"t.?,,n");
			  ds_list_add(f,"u,-=*y");
			  ds_list_add(f,"yy!=*n");
			 
			  
			  ds_list_add(g,"a,?=*y");
			  ds_list_add(g,"e,?=*y");
			  ds_list_add(g,"g.-,,n");
			  ds_list_add(g,"h.,,,y");
			  ds_list_add(g,"i,-=*y");
			  ds_list_add(g,"l.-=*y");
			  ds_list_add(g,"n.-=*y");
			  ds_list_add(g,"o,?=*y");
			  ds_list_add(g,"r.-=*y");
			  ds_list_add(g,"u,?=*y");
			  ds_list_add(g,"w.-=*n");
			  ds_list_add(g,"yy!,*n");
			 
			  
			  ds_list_add(h,"a,?=*y");
			  ds_list_add(h,"e,-=*y");
			  ds_list_add(h,"i,-=*y");
			  ds_list_add(h,"o,?=*y");
			  ds_list_add(h,"u,-=*y");
			 
			  
			  ds_list_add(i,"a,?..y");
			  ds_list_add(i,"b.?=*y");
			  ds_list_add(i,"c.-=*y");
			  ds_list_add(i,"d.?=*y");
			  ds_list_add(i,"e,?..n");
			  ds_list_add(i,"f.?=*y");
			  ds_list_add(i,"g._=*y");
			  ds_list_add(i,"l.?=*y");
			  ds_list_add(i,"m.?=*y");
			  ds_list_add(i,"n.?=*y");
			  ds_list_add(i,"o,?..n");
			  ds_list_add(i,"p.?=*y");
			  ds_list_add(i,"q.-=,y");
			  ds_list_add(i,"r.-=*y");
			  ds_list_add(i,"s.?=*y");
			  ds_list_add(i,"t.?=*y");
			  ds_list_add(i,"v.!=*y");
			  ds_list_add(i,"x.-=*y");
			  ds_list_add(i,"z.-=*y");
			 
			  
			  ds_list_add(j,"a,?=*y");
			  ds_list_add(j,"e,,=*y");
			  ds_list_add(j,"i,-=*y");
			  ds_list_add(j,"o,?=*y");
			  ds_list_add(j,"u,-=*y");
			  ds_list_add(j,"yy!=*n");
			 
			  
			  ds_list_add(k,"a,?=*y");
			  ds_list_add(k,"e,,=*y");
			  ds_list_add(k,"i,-=*y");
			  ds_list_add(k,"l.-=*y");
			  ds_list_add(k,"o,?=*y");
			  ds_list_add(k,"r.-=*y");
			  ds_list_add(k,"u,-=*y");
			  ds_list_add(k,"w.-=*n");
			  ds_list_add(k,"yy!=*n");
			 
			  
			  ds_list_add(l,"a,?=*y");
			  ds_list_add(l,"b.?,,n") ;
			  ds_list_add(l,"c.-,,n");
			  ds_list_add(l,"d.?,,n");
			  ds_list_add(l,"e,?=*y");
			  ds_list_add(l,"f.?,,n");
			  ds_list_add(l,"g.?,,n");
			  ds_list_add(l,"i,-=*y");
			  ds_list_add(l,"k.?,,n");
			  ds_list_add(l,"l.?,,n");
			  ds_list_add(l,"m.?,,n");
			  ds_list_add(l,"n.?,,n");
			  ds_list_add(l,"o,?=*y");
			  ds_list_add(l,"p.?,,n");
			  ds_list_add(l,"q.-,,n");
			  ds_list_add(l,"s.-,,n");
			  ds_list_add(l,"t.?,,n");
			  ds_list_add(l,"u,-=*y");
			  ds_list_add(l,"v.-,,n");
			  ds_list_add(l,"yy!=*n");
			 
			  
			  ds_list_add(m,"a,?=*y");
			  ds_list_add(m,"b.,,,n");
			  ds_list_add(m,"e,,=*y");
			  ds_list_add(m,"i,-=*y");
			  ds_list_add(m,"k.,,,n");
			  ds_list_add(m,"m.-,,n");
			  ds_list_add(m,"o,?=*y");
			  ds_list_add(m,"p.,,,n");
			  ds_list_add(m,"s.?,*n");
			  ds_list_add(m,"u,-=*y");
			  ds_list_add(m,"yy!=*n");
			 
			  
			  ds_list_add(n,"a,?=*y");
			  ds_list_add(n,"d.?,,n");
			  ds_list_add(n,"e,,=*y");
			  ds_list_add(n,"g.?,*n");
			  ds_list_add(n,"i,-=*y");
			  ds_list_add(n,"k.,,,n");
			  ds_list_add(n,"n.-,,n");
			  ds_list_add(n,"o,?=*y");
			  ds_list_add(n,"p.,,,n");
			  ds_list_add(n,"s.?,*n");
			  ds_list_add(n,"t.?,,n");
			  ds_list_add(n,"u,-=*y");
			  ds_list_add(n,"v.-,,n");
			  ds_list_add(n,"yy!=*n");
			 
			  
			  ds_list_add(o,"a,?..y");
			  ds_list_add(o,"b.?=*y");
			  ds_list_add(o,"c.-=*y");
			  ds_list_add(o,"d.?=*y");
			  ds_list_add(o,"f.-=*y");
			  ds_list_add(o,"g.?=*y");
			  ds_list_add(o,"h.?=*y");
			  ds_list_add(o,"i,-..y");
			  ds_list_add(o,"j.-.,y");
			  ds_list_add(o,"k.-=*y");
			  ds_list_add(o,"l.?=*y");
			  ds_list_add(o,"m.?=*y");
			  ds_list_add(o,"n.?=*y");
			  ds_list_add(o,"o,-..y");
			  ds_list_add(o,"p.?=*y");
			  ds_list_add(o,"q.-=,y");
			  ds_list_add(o,"r.?=*y");
			  ds_list_add(o,"s.?=*y");
			  ds_list_add(o,"t.?=*y");
			  ds_list_add(o,"u,-..y");
			  ds_list_add(o,"v.-=,y");
			  ds_list_add(o,"w.?,*y");
			  ds_list_add(o,"x.?=*y");
			  ds_list_add(o,"yy!.*n");
			  ds_list_add(o,"z.?=*y");
			 
		   	  
			  ds_list_add(p,"a,?=*y");
			  ds_list_add(p,"e,,,*y");
			  ds_list_add(p,"h.,,*y");
			  ds_list_add(p,"i,-=*y");
			  ds_list_add(p,"l.-=*y");
			  ds_list_add(p,"o,?=*y");
			  ds_list_add(p,"p.-,,n");
			  ds_list_add(p,"r.-,,y");
			  ds_list_add(p,"u,-=*y");
			  ds_list_add(p,"yy!=*n");
			 
			  
			  ds_list_add(q,"u,-=,y");
			 
		 	  
			  ds_list_add(r,"a,?=*y");
			  ds_list_add(r,"b.?,,n");
			  ds_list_add(r,"d.?,,n");
			  ds_list_add(r,"e,,=*y");
			  ds_list_add(r,"f.?,,n");
			  ds_list_add(r,"g.?,,n");
			  ds_list_add(r,"i,-=*y");
			  ds_list_add(r,"j.-,,n");
			  ds_list_add(r,"k.?,,n");
			  ds_list_add(r,"l.?,,n");
			  ds_list_add(r,"m.?,,n");
			  ds_list_add(r,"n.?,,n");
			  ds_list_add(r,"o,?=*y");
			  ds_list_add(r,"p.?,,n");
			  ds_list_add(r,"q.-,,n");
			  ds_list_add(r,"r.-,,n");
			  ds_list_add(r,"s.?,,n");
			  ds_list_add(r,"t.?,,n");
			  ds_list_add(r,"u,-=*y");
			  ds_list_add(r,"v.-,,n");
			  ds_list_add(r,"x.?,,n");
			  ds_list_add(r,"yy!=*n");
			 
		      
			  ds_list_add(s,"a,?=*y");
			  ds_list_add(s,"c.?,,y");
			  ds_list_add(s,"e,,=*y");
			  ds_list_add(s,"h.?,,y");
			  ds_list_add(s,"i,-=*y");
			  ds_list_add(s,"k.?,,y");
			  ds_list_add(s,"l.-,,y");
			  ds_list_add(s,"m.?,,y");
			  ds_list_add(s,"n.-,,n");
			  ds_list_add(s,"o,?=*y");
			  ds_list_add(s,"p.-,*y");
			  ds_list_add(s,"s.-,,n");
			  ds_list_add(s,"t.?,,y");
			  ds_list_add(s,"u,-=*y");
			  ds_list_add(s,"w.-=,y");
			  ds_list_add(s,"yy!=*n");
			 
			  
			  ds_list_add(t,"a,?=*y");
			  ds_list_add(t,"e,,=*y");
			  ds_list_add(t,"h.?,,y");
			  ds_list_add(t,"i,-=*y");
			  ds_list_add(t,"l.-,,n");
			  ds_list_add(t,"o,?=*y");
			  ds_list_add(t,"r.-=,y");
			  ds_list_add(t,"t.-,,n");
			  ds_list_add(t,"u,-=*y");
			  ds_list_add(t,"w.-=,y");
			  ds_list_add(t,"yy!=*n");
			 
			  
			  ds_list_add(u,"a,?..y");
			  ds_list_add(u,"b.?=*y");
			  ds_list_add(u,"c.-=*y");
			  ds_list_add(u,"d.?=*y");
			  ds_list_add(u,"e,?..n");
			  ds_list_add(u,"f.?=*y");
			  ds_list_add(u,"g.?=*y");
			  ds_list_add(u,"h.?.*y");
			  ds_list_add(u,"i,-..n");
			  ds_list_add(u,"l.?=*y");
			  ds_list_add(u,"m.?=*y");
			  ds_list_add(u,"n.?=*y");
			  ds_list_add(u,"o,-..n");
			  ds_list_add(u,"p.?=*y");
			  ds_list_add(u,"q.-=,y");
			  ds_list_add(u,"r.?=*y");
			  ds_list_add(u,"s.?=*y");
			  ds_list_add(u,"t.?=*y");
			  ds_list_add(u,"v.?=*y");
			  ds_list_add(u,"x.?=*y");
			  ds_list_add(u,"z.?=*y");
			 
			  
			  ds_list_add(v,"a,?=*y");
			  ds_list_add(v,"e,,=*y");
			  ds_list_add(v,"i,-=*y");
			  ds_list_add(v,"o,?=*y");
			  ds_list_add(v,"u,-=*y");
			  ds_list_add(v,"y,!=*n");
			
			  
			  ds_list_add(w,"a,?=*y");
			  ds_list_add(w,"e,-=*y");
			  ds_list_add(w,"h.-=*y");
			  ds_list_add(w,"i,-=*y");
			  ds_list_add(w,"o,?=*y");
			  ds_list_add(w,"r.-=*y");
			  ds_list_add(w,"u,-=*y");
			
			  ds_list_add(xx,"a,?=*n");
			  ds_list_add(xx,"e,,=*n");
			  ds_list_add(xx,"i,-=*n");
			  ds_list_add(xx,"l.-=*n");
			  ds_list_add(xx,"o,?=*n");
			  ds_list_add(xx,"r.-=*n");
			  ds_list_add(xx,"u,-=*n");
			  ds_list_add(xx,"yy!=*n");
			
			  ds_list_add(yy,"a,?=*y");
			  ds_list_add(yy,"e,-=*y");
			  ds_list_add(yy,"i,-=*y");
			  ds_list_add(yy,"o,?=*y");
			  ds_list_add(yy,"u,-=*y");
			 
			  ds_list_add(z,"a,?=*y");
			  ds_list_add(z,"e,,=*y");
			  ds_list_add(z,"i,-=*y");
			  ds_list_add(z,"o,?=*y");
			  ds_list_add(z,"u,-=*y");
			  ds_list_add(z,"yy!=*n");
			 
			  ds_map_addsa(letters,"a",a); //maps letters onto respective lists
			  ds_map_addsa(letters,"b",b);
			  ds_map_addsa(letters,"c",c);
			  ds_map_addsa(letters,"d",d);
			  ds_map_addsa(letters,"e",e);
			  ds_map_addsa(letters,"f",f);
			  ds_map_addsa(letters,"g",g);
			  ds_map_addsa(letters,"h",h);
			  ds_map_addsa(letters,"i",i);
			  ds_map_addsa(letters,"j",j);
			  ds_map_addsa(letters,"k",k);
			  ds_map_addsa(letters,"l",l);
			  ds_map_addsa(letters,"m",m);
			  ds_map_addsa(letters,"n",n);
			  ds_map_addsa(letters,"o",o);
			  ds_map_addsa(letters,"p",p);
			  ds_map_addsa(letters,"q",q);
			  ds_map_addsa(letters,"r",r);
			  ds_map_addsa(letters,"s",s);
			  ds_map_addsa(letters,"t",t);
			  ds_map_addsa(letters,"u",u);
			  ds_map_addsa(letters,"v",v);
			  ds_map_addsa(letters,"w",w);
			  ds_map_addsa(letters,"x",xx);
			  ds_map_addsa(letters,"y",yy);
			  ds_map_addsa(letters,"z",z);
			 
			  ds_list_add(alphabet,"a,");
			  ds_list_add(alphabet,"b.");
			  ds_list_add(alphabet,"c.");
			  ds_list_add(alphabet,"d.");
			  ds_list_add(alphabet,"e,");
			  ds_list_add(alphabet,"f.");
			  ds_list_add(alphabet,"g.");
			  ds_list_add(alphabet,"h.");
			  ds_list_add(alphabet,"i,");
			  ds_list_add(alphabet,"j.");
			  ds_list_add(alphabet,"k.");
			  ds_list_add(alphabet,"l.");
			  ds_list_add(alphabet,"m.");
			  ds_list_add(alphabet,"n.");
			  ds_list_add(alphabet,"o,");
			  ds_list_add(alphabet,"p.");
			  ds_list_add(alphabet,"q.");
			  ds_list_add(alphabet,"r.");
			  ds_list_add(alphabet,"s.");
			  ds_list_add(alphabet,"t.");
			  ds_list_add(alphabet,"u,");
			  ds_list_add(alphabet,"v.");
			  ds_list_add(alphabet,"w.");
			  ds_list_add(alphabet,"yy");
			  ds_list_add(alphabet,"z.");
			 
			  ds_map_addsi(prob,"a",1); //maps letters on their probability of being picked.
			  ds_map_addsi(prob,"b",2);
			  ds_map_addsi(prob,"c",2);
			  ds_map_addsi(prob,"d",2);
			  ds_map_addsi(prob,"e",1);
			  ds_map_addsi(prob,"f",4);
			  ds_map_addsi(prob,"g",2);
			  ds_map_addsi(prob,"h",4);
			  ds_map_addsi(prob,"i",1);
			  ds_map_addsi(prob,"j",8);
			  ds_map_addsi(prob,"k",5);
			  ds_map_addsi(prob,"l",1);
			  ds_map_addsi(prob,"m",3);
			  ds_map_addsi(prob,"n",1);
			  ds_map_addsi(prob,"o",1);
			  ds_map_addsi(prob,"p",3);
			  ds_map_addsi(prob,"q",9);
			  ds_map_addsi(prob,"r",1);
			  ds_map_addsi(prob,"s",1);
			  ds_map_addsi(prob,"t",1);
			  ds_map_addsi(prob,"u",4);
			  ds_map_addsi(prob,"v",4);
			  ds_map_addsi(prob,"w",4);
			  ds_map_addsi(prob,"x",8);
			  ds_map_addsi(prob,"y",4);
			  ds_map_addsi(prob,"z",8);
	}

			 public String generate(int len)
			 {
				 long st = System.currentTimeMillis();
				          String l_string="";  //string containing word being generated
						  String vString="";   //string containing vowel/cons states of letters
						  String let="";
						  ArrayList<String> set;
						  int prb;
						  int content=0;
						  int starting=1;
						  do
						  {
						   let=ds_list_find_value(alphabet,irandom_range(0,24));    //random letter a-z + vowel/cons status
						   set=ds_map_find_valuesa(letters,sub(let,1));               //arraylist of let
						   prb=ds_map_find_valuesi(prob,sub(let,1));                  //probability of picking that letter
						   if (irandom_range(1,10) > prb)
						   {
						    content = 1;}
						  }while (content != 1);
						  l_string+=sub(let,1); 
						  vString+=sub(let,2) ;
						  String rl="";     
						  String rv="";     
						  String re="";     
						  String rp="";
						  String rn="";
						  String rb="";
						  int tp=0;
						  int count=0;
						  while(tp == 0)
						  {
						   tp=1;
						   count=irandom_range(0,ds_list_size(set)-1);
						   rl=sub(ds_list_find_value(set,count),1);
						   rv=sub(ds_list_find_value(set,count),2);
						   re=sub(ds_list_find_value(set,count),3);
						   rp=sub(ds_list_find_value(set,count),4);
						   rn=sub(ds_list_find_value(set,count),5);
						   rb=sub(ds_list_find_value(set,count),6);
						   /*if (rp != "=" && rp != sub(vString,vString.length()) && starting == 0)
						   {
						    tp=0;}*/
						   if (starting == 1 && rb.equals("n"))
						   {
						    tp=0;}
						   if (l_string.length() < 4 && re.equals("!"))
						   {
						    tp=0;}
						  }
						  l_string+=rl;
						  vString+=rv;
						  starting=0;
						  set=ds_map_find_valuesa(letters,rl);
						  int goin=1;
						  do
						  {
						   String must=rn;
						   do
						   {
						    tp=1;
						    count=irandom_range(0,ds_list_size(set)-1);
						    rl=sub(ds_list_find_value(set,count),1);
						    rv=sub(ds_list_find_value(set,count),2);
						    re=sub(ds_list_find_value(set,count),3);
						    rp=sub(ds_list_find_value(set,count),4);
						    rn=sub(ds_list_find_value(set,count),5);
						    rb=sub(ds_list_find_value(set,count),6);
						    if (!(rp.equals("=")) && !(rp.equals(sub(vString,vString.length()-1))) && starting == 0)
						    {
						     tp=0;}
						    if (l_string.length()<4 && re.equals("!"))
						    {
						     tp=0;}
						    if (!(must.equals("*")) && !(must.equals(rv)))
						    {
						     tp=0;}
						    prb=ds_map_find_valuesi(prob,rl);
						    if (irandom_range(1,10)<prb)
						    {
						     tp=0;}
						    if (rv.equals(",") && sub(vString,vString.length()).equals(",") && irandom_range(0,100)>75)
						    {
						     tp=0;}
						    if ((re.equals("-") && l_string.length() >= len) || (re.equals("!") && l_string.length() < len-1))
						    {
						     tp=0;}
						    if (rl.equals("q") && l_string.length() == len - 1)
						    {
						     tp=0;}
						   } while( tp!=1 );
						   l_string+=rl;
						   vString+=rv;
						   if( !(re.equals("-")) && re.equals("!") || (re.equals("?") && l_string.length()>=4 && irandom_range(1,len)<l_string.length() && l_string.length()>=len))
						   {
						    goin=0;}
						   set=ds_map_find_valuesa(letters,rl);
						   if (!(re.equals("-")) && l_string.length()>=len)
						   {
						    goin=0;}
						  } while(goin!=0);
						  long et = System.currentTimeMillis();
						  return l_string;
						 }
			 }

