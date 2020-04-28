package com.ruoyi.tool.domain;

import java.util.List;

public class SqlBeautModel {

	private String key;
	
	private int type; 
	
	private List<SqlBeautModel> querys;
	
	private SqlBeautModel from;
	
	private List<SqlBeautModel> join;
	
	private SqlBeautModel where;
	
	private List<SqlBeautModel> and;
	
	private SqlBeautModel having;
	
	private List<SqlBeautModel> group;
	
	private List<SqlBeautModel> order;
	
	private int depth;
	
	private String open;
	
	private String close;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<SqlBeautModel> getQuerys() {
		return querys;
	}

	public void setQuerys(List<SqlBeautModel> querys) {
		this.querys = querys;
	}

	public SqlBeautModel getFrom() {
		return from;
	}

	public void setFrom(SqlBeautModel from) {
		this.from = from;
	}

	public List<SqlBeautModel> getJoin() {
		return join;
	}

	public void setJoin(List<SqlBeautModel> join) {
		this.join = join;
	}

	public SqlBeautModel getWhere() {
		return where;
	}

	public void setWhere(SqlBeautModel where) {
		this.where = where;
	}

	public List<SqlBeautModel> getAnd() {
		return and;
	}

	public void setAnd(List<SqlBeautModel> and) {
		this.and = and;
	}

	public SqlBeautModel getHaving() {
		return having;
	}

	public void setHaving(SqlBeautModel having) {
		this.having = having;
	}

	public List<SqlBeautModel> getGroup() {
		return group;
	}

	public void setGroup(List<SqlBeautModel> group) {
		this.group = group;
	}

	public List<SqlBeautModel> getOrder() {
		return order;
	}

	public void setOrder(List<SqlBeautModel> order) {
		this.order = order;
	}
	
	
	public String getReqult(){
		
		StringBuilder res = new StringBuilder(key);
		
		for(SqlBeautModel query : this.querys){
			query.depth = this.depth + 1;
			
			res.append(getTab());
			res.append(query.open);
			res.append(query.getReqult());
			res.append(query.close);
			res.append(",");
			res.append("\n");
		}
		
		return res.toString();
	}
	
	private String getTab(){
		String res = "";
		for(int i = 0; i < depth*2; i++){
			res += " ";
		}
		return res;
	}
	
	private void check(){
		
		
		
	}
}
