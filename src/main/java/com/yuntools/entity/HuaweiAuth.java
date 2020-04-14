package com.yuntools.entity;

import sun.security.util.Password;

import java.util.List;

/**
 * huawei auth 认证token封装请求类
 */
public class HuaweiAuth {

	private Identity_scope auth;

	public Identity_scope getAuth() {
		return auth;
	}

	public void setAuth(Identity_scope auth) {
		this.auth = auth;
	}

	public static class Identity_scope{
		private Identity identity;

		private Scope scope;

		public Identity getIdentity() {
			return identity;
		}

		public void setIdentity(Identity identity) {
			this.identity = identity;
		}

		public Scope getScope() {
			return scope;
		}

		public void setScope(Scope scope) {
			this.scope = scope;
		}

		public static class Identity{
			private List<String> methods;

			private Password password;

			public List<String> getMethods() {
				return methods;
			}

			public void setMethods(List<String> methods) {
				this.methods = methods;
			}

			public Password getPassword() {
				return password;
			}

			public void setPassword(Password password) {
				this.password = password;
			}

			public static class Password{
				private User user;

				public User getUser() {
					return user;
				}

				public void setUser(User user) {
					this.user = user;
				}

				public static class User{
					private String name;

					private String password;

					private Domain domain;

					public String getName() {
						return name;
					}

					public void setName(String name) {
						this.name = name;
					}

					public String getPassword() {
						return password;
					}

					public void setPassword(String password) {
						this.password = password;
					}

					public Domain getDomain() {
						return domain;
					}

					public void setDomain(Domain domain) {
						this.domain = domain;
					}
				}

			}

		}

		public static class Scope{
			private Domain domain;

			public Domain getDomain() {
				return domain;
			}

			public void setDomain(Domain domain) {
				this.domain = domain;
			}
		}
	}

}
