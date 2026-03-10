package practice.layerPractice.entity.description.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParent is a Querydsl query type for Parent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParent extends EntityPathBase<Parent> {

    private static final long serialVersionUID = 1973470354L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParent parent = new QParent("parent");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> localDateTest = createDate("localDateTest", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> localDateTimeTest = createDateTime("localDateTimeTest", java.time.LocalDateTime.class);

    public final ListPath<practice.layerPractice.entity.description.Period, practice.layerPractice.entity.description.QPeriod> periodList = this.<practice.layerPractice.entity.description.Period, practice.layerPractice.entity.description.QPeriod>createList("periodList", practice.layerPractice.entity.description.Period.class, practice.layerPractice.entity.description.QPeriod.class, PathInits.DIRECT2);

    public final EnumPath<practice.layerPractice.entity.RoleType> roleType = createEnum("roleType", practice.layerPractice.entity.RoleType.class);

    public final QSon son;

    public final StringPath username = createString("username");

    public final practice.layerPractice.entity.description.QPeriod workPeriod;

    public QParent(String variable) {
        this(Parent.class, forVariable(variable), INITS);
    }

    public QParent(Path<? extends Parent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParent(PathMetadata metadata, PathInits inits) {
        this(Parent.class, metadata, inits);
    }

    public QParent(Class<? extends Parent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.son = inits.isInitialized("son") ? new QSon(forProperty("son")) : null;
        this.workPeriod = inits.isInitialized("workPeriod") ? new practice.layerPractice.entity.description.QPeriod(forProperty("workPeriod")) : null;
    }

}

