package practice.layerPractice.sql.sqlEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductSQL is a Querydsl query type for ProductSQL
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductSQL extends EntityPathBase<ProductSQL> {

    private static final long serialVersionUID = 1630895985L;

    public static final QProductSQL productSQL = new QProductSQL("productSQL");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> stockAmount = createNumber("stockAmount", Integer.class);

    public QProductSQL(String variable) {
        super(ProductSQL.class, forVariable(variable));
    }

    public QProductSQL(Path<? extends ProductSQL> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductSQL(PathMetadata metadata) {
        super(ProductSQL.class, metadata);
    }

}

