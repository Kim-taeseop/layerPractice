package practice.layerPractice.entity.baseEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDataBaseEntity is a Querydsl query type for DataBaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QDataBaseEntity extends EntityPathBase<DataBaseEntity> {

    private static final long serialVersionUID = 1050773346L;

    public static final QDataBaseEntity dataBaseEntity = new QDataBaseEntity("dataBaseEntity");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public QDataBaseEntity(String variable) {
        super(DataBaseEntity.class, forVariable(variable));
    }

    public QDataBaseEntity(Path<? extends DataBaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDataBaseEntity(PathMetadata metadata) {
        super(DataBaseEntity.class, metadata);
    }

}

