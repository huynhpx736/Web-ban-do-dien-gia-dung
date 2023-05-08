package ptithcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.Entity.ThuongHieuEntity;

@Repository
public class ThuongHieuDAOImpl implements ThuongHieuDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ThuongHieuEntity> layThuongHieu() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ThuongHieuEntity where trangThai=True";
		Query query = session.createQuery(hql);
	    List<ThuongHieuEntity> listThuongHieu = query.list();
	    return listThuongHieu;
	}

	@Override
	public List<ThuongHieuEntity> layThuongHieuDaNgung() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ThuongHieuEntity where trangThai=False";
		Query query = session.createQuery(hql);
	    List<ThuongHieuEntity> listThuongHieu = query.list();
	    return listThuongHieu;
	}

	@Override
	public ThuongHieuEntity layThuongHieuTheoMa(String maTh) {
		Session session = sessionFactory.getCurrentSession();
	    ThuongHieuEntity thuongHieu = (ThuongHieuEntity) session.get(ThuongHieuEntity.class, maTh);
	    return thuongHieu;
	}

}
