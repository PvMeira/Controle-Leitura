package com.senac.wir.transactional;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import com.senac.wir.util.MessengerSystem;

@Interceptor @Transactional
public class TransacionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;

	@AroundInvoke
	public Object intercept(InvocationContext context){
		Object result = null;

		try {
			entityManager.getTransaction().begin();

			result = context.proceed();

			entityManager.getTransaction().commit();

		} catch (Exception e) {

			entityManager.getTransaction().rollback();

			MessengerSystem.notifyError("Error - ",
					"Details of the Error: " + e.getClass().getName() + " - " + e.getMessage());

			e.printStackTrace();
		}

		return result;
	}
}
