package practice.layerPractice.sql.sqlEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAddressSQL is a Querydsl query type for AddressSQL
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QAddressSQL extends BeanPath<AddressSQL> {

    private static final long serialVersionUID = 1218942540L;

    public static final QAddressSQL addressSQL = new QAddressSQL("addressSQL");

    public final StringPath city = createString("city");

    public final StringPath street = createString("street");

    public final StringPath zipcode = createString("zipcode");

    public QAddressSQL(String variable) {
        super(AddressSQL.class, forVariable(variable));
    }

    public QAddressSQL(Path<? extends AddressSQL> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddressSQL(PathMetadata metadata) {
        super(AddressSQL.class, metadata);
    }

}

