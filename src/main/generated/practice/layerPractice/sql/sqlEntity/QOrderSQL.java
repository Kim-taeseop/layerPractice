package practice.layerPractice.sql.sqlEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderSQL is a Querydsl query type for OrderSQL
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderSQL extends EntityPathBase<OrderSQL> {

    private static final long serialVersionUID = -754659022L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderSQL orderSQL = new QOrderSQL("orderSQL");

    public final QAddressSQL addressSQL;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> orderAmount = createNumber("orderAmount", Integer.class);

    public final QProductSQL productSQL;

    public QOrderSQL(String variable) {
        this(OrderSQL.class, forVariable(variable), INITS);
    }

    public QOrderSQL(Path<? extends OrderSQL> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderSQL(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderSQL(PathMetadata metadata, PathInits inits) {
        this(OrderSQL.class, metadata, inits);
    }

    public QOrderSQL(Class<? extends OrderSQL> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.addressSQL = inits.isInitialized("addressSQL") ? new QAddressSQL(forProperty("addressSQL")) : null;
        this.productSQL = inits.isInitialized("productSQL") ? new QProductSQL(forProperty("productSQL")) : null;
    }

}

