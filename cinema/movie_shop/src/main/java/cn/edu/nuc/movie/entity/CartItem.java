package cn.edu.nuc.movie.entity;

/**
 * 购物项对象
 * @author kengkeng
 *
 */
public class CartItem {

	private Movie movie; //购物项中商品信息
	private int count; //购物这个商品数量
	private double subtotal;//购买此商品小计
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count * movie.getShopprice();
	}
	
}
