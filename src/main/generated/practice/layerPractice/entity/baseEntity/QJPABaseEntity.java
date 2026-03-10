package practice.layerPractice.entity.baseEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJPABaseEntity is a Querydsl query type for JPABaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QJPABaseEntity extends EntityPathBase<JPABaseEntity> {

    private static final long serialVersionUID = 571470283L;

    public static final QJPABaseEntity jPABaseEntity = new QJPABaseEntity("jPABaseEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedDate = createDateTime("updatedDate", java.time.LocalDateTime.class);

    public QJPABaseEntity(String variable) {
        super(JPABaseEntity.class, forVariable(variable));
    }

    public QJPABaseEntity(Path<? extends JPABaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJPABaseEntity(PathMetadata metadata) {
        super(JPABaseEntity.class, metadata);
    }

}

