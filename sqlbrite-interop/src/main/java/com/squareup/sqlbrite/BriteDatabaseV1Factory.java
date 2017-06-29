package com.squareup.sqlbrite;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.RestrictTo;
import java.util.Set;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;

import static android.support.annotation.RestrictTo.Scope.LIBRARY;

@RestrictTo(LIBRARY)
public final class BriteDatabaseV1Factory {
  private BriteDatabaseV1Factory() {
    throw new AssertionError("No instances");
  }

  public static BriteDatabase create(SqlBrite sqlBrite, SQLiteOpenHelper helper,
      Observable<Set<String>> triggerSource, Observer<Set<String>> triggerSink,
      Scheduler scheduler) {
    return new BriteDatabase(helper, sqlBrite.logger, triggerSource, triggerSink, scheduler,
        sqlBrite.queryTransformer);
  }
}
