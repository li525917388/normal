package com.ruoyi.tool.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 美化sql工具实体类
 * @author Li Dehuan
 * @date 2020年3月11日
 *
 */
public class SqlBeaufString {

	private String sql;	
	
	private StringBuilder result;
	
	private StringBuilder temp;
	
	private int index;
	
	private int length;
	
	private List<Character> chars;
	
	private List<String> identifiers;		// 正
	
	private List<String> identifiers2;		// 反
	
	private List<String> identifiers3;		// 正和反
	
	private StringBuilder tab;				// tab
	
	private boolean isChar;	
	
	public SqlBeaufString(String sql){
		if(sql == null) throw new NullPointerException("我太难了！老铁，起码至少也要传个空串吧");
		this.sql = sql;
		this.index = 0;
		this.length = sql.length();
		temp = new StringBuilder();
		result = new StringBuilder();
		tab = new StringBuilder();
		
		chars = new ArrayList<Character>();
		chars.add(' ');
		chars.add('(');
		
		identifiers = new ArrayList<String>();
		identifiers.add("insert");
		identifiers.add("update");
		identifiers.add("delete");
		identifiers.add("select");
		
		identifiers2 = new ArrayList<String>();
		identifiers.add(")");
		
		identifiers3 = new ArrayList<String>();
		identifiers3.add("from");
		identifiers3.add("where");
		
	}
	
	public void beautify(){
		if(index >= length) {
			result.append(tab);
			result.append(temp);	
			return;
		}
		
		char c = sql.charAt(index);
		
		if(c == '\''){
			result.append(temp);
			result.append(c);
			temp.delete(0, temp.length());
			for(int i = index + 1; i < length; i++){
				char cText = sql.charAt(index);
				if(cText == '\''){
					result.append(cText);
					index ++;
					beautify();
					return;
				}
			}
		}
		
		if(c == ','){
			result.append(tab);
			result.append(temp);
			result.append(',');
			result.append("\n");
			temp.delete(0, temp.length());
			index ++;
			beautify();
			return;
		}
		
		if(chars.contains(c)){
			result.append(c);
			decide();
			beautify();
		}else{
			index ++;
			temp.append(c);
			beautify();
		}
	}
	
	
	public void decide(){
		
		boolean isIde = false;
		
		for(String ide : identifiers){
			if(ide.equalsIgnoreCase(this.temp.toString())){
				result.append(tab);
				result.append(this.temp.toString());
				result.append("\n");
				tab.append("  ");
				temp.delete(0, temp.length());
				isIde = true;
				break;
			}
		}
		
		for(String ide : identifiers2){
			if(ide.equalsIgnoreCase(this.temp.toString())){
				if(tab.length() >= 2){
					tab.delete(tab.length() - 2, tab.length());
				}
				result.append(tab);
				result.append(this.temp.toString());
				result.append("\n");
				isIde = true;
				break;
			}
		}
		
		
		for(String ide : identifiers3){
			if(ide.equalsIgnoreCase(this.temp.toString())){
				result.append("\n");
				if(tab.length() >= 2){
					result.append(tab.substring(0, tab.length() - 2));
				}
				result.append(this.temp.toString());
				result.append("\n");
				temp.delete(0, temp.length());
				isIde = true;
				break;
			}
		}

		if(!isIde){
			result.append(temp);
			temp.delete(0, temp.length());
		}
		
		
		index ++;
		
	}
	
	public String getResult(){
		return result.toString();
	}
	
	
	
	
	
	public void sf(){

		for(int i = index; i < length; i++){
			
			char c = sql.charAt(i);
			
			if(c == ' '){

				if("SELECT".equalsIgnoreCase(temp.toString())){
					result.append(tab);
					result.append(temp);
					result.append('\n');
					temp.delete(0, temp.length());
					tab.append("  ");
					result.append(tab);
				} else if("FROM".equalsIgnoreCase(temp.toString())){
					result.append('\n');
					result.append(tab.substring(0, tab.length() - 2));
					result.append(temp);
					result.append('\n');
					temp.delete(0, temp.length());
					result.append(tab);
				} else{
					result.append(temp);
					result.append(c);
					temp.delete(0, temp.length());
				}
			} else if(c == '('){

				result.append(tab);
				
				if("SELECT".equalsIgnoreCase(temp.toString())){
					result.append(tab);
					result.append(temp);
					result.append('\n');
					temp.delete(0, temp.length());
					tab.append("  ");
					result.append(tab);
				} else{
					result.append(temp);
					result.append(c);
					temp.delete(0, temp.length());
				}
				
				result.append('\n');
				tab.append("  ");
				
				
			}  else if(c == ')'){
				//result.append(tab);
				
				if("SELECT".equalsIgnoreCase(temp.toString())){
					result.append(tab);
					result.append(temp);
					result.append('\n');
					temp.delete(0, temp.length());
					tab.append("  ");
					result.append(tab);
				} else{
					result.append(temp);
					result.append('\n');
					result.append(tab);
					result.append(c);
					temp.delete(0, temp.length());
				}
				
				tab.delete(tab.length() - 2, tab.length());
				
			} else if(c == ','){
				result.append(temp);
				result.append(c);
				result.append('\n');
				temp.delete(0, temp.length());
				
			} else{
				temp.append(c);
			}
		}
		
		result.append(tab);
		result.append(temp);
	}
	
	public void select(){
		
		
	}
}
