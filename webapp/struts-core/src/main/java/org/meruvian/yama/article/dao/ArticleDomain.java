package org.meruvian.yama.article.dao;

import javax.persistence.TypedQuery;

import org.apache.commons.lang.StringUtils;
import org.meruvian.yama.article.Article;
import org.meruvian.yama.persistence.EntityListWrapper;
import org.meruvian.yama.persistence.LogInformation.StatusFlag;
import org.meruvian.yama.persistence.access.PersistenceDAO;
import org.meruvian.yama.persistence.utils.PagingUtils;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDomain extends PersistenceDAO<Article>{
	
	public EntityListWrapper<Article> findArticles(String title, String orderby,
			String order, int max, int page, String condition) {
		String criteria = "(c.title LIKE ?)";
		criteria = criteria.replace("AND", condition);
		criteria += " AND c.logInformation.statusFlag = ? ORDER BY " + orderby
				+ " " + order;

		Object[] params = { title, StatusFlag.ACTIVE };
		for (int i = 0; i < params.length - 1; i++) {
			if (params[i] instanceof String || params[i] == null) {
				params[i] = StringUtils.defaultIfEmpty((String) params[i], "");
				params[i] = StringUtils.join(new String[] { "%",
						(String) params[i], "%" });
			}
		}

		TypedQuery<Article> query = createQuery(entityClass, "c", "c", criteria,
				params);
		if (max > 0) {
			query.setMaxResults(max);
		}
		query.setFirstResult(page * max);

		long rowcount = getRowCount("c", criteria, params);
		EntityListWrapper<Article> list = new EntityListWrapper<Article>();
		list.setCurrentPage(page);
		list.setEntityList(query.getResultList());
		list.setLimit(max);
		list.setRowCount(rowcount);
		list.setTotalPage(PagingUtils.getTotalPage(rowcount, max));

		return list;
	}

}
