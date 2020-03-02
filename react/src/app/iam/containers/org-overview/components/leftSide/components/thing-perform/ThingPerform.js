import React, { useEffect, useState } from 'react';
import { observer } from 'mobx-react-lite';
import ContainerBlock from '../../../ContainerBlock';
import Charts from './Charts';
import FailedStatistics from './FailedStatistics';
import { useFailedStatisticsStore } from './stores';

import './index.less';

const ThingPerform = observer(() => {
  const [chosenDays, setChosenDays] = useState(7);

  const {
    ThingPerformStore,
    FailedStatisticsTableDataSet,
    AppState: {
      menuType: { orgId },
    },
  } = useFailedStatisticsStore();

  const initData = (days) => {
    ThingPerformStore.initThingPerformChartData(orgId, days);
    FailedStatisticsTableDataSet.setQueryParameter('date', days);
    FailedStatisticsTableDataSet.query();
  };

  useEffect(() => {
    initData(chosenDays);
  }, []);

  const handleChangeDays = (days) => {
    setChosenDays(days);
    initData(days);
  };
  return (
    <div className="c7n-overview-thingPerform">
      <ContainerBlock
        width="100%"
        title="事务执行情况"
        hasDaysPicker
        handleChangeDays={handleChangeDays}
      >
        <Charts />
        <FailedStatistics />
      </ContainerBlock>
    </div>
  );
});

export default ThingPerform;
