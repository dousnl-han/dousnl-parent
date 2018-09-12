package org.dousnl.genericity;

/**
 * @author Fairyland
 * 接口泛型
 */
class Coffer{}
class Mocha extends Coffer{}

public class GeneranteImpl implements GeneranteInterface<Coffer> {

	@Override
	public Coffer next() {
		return new Mocha();
	}

}
