
export default () => ({
  autoQuery: false,
  autoCreate: false,
  selection: false,
  transport: {
    read: {
      url: '/devops/v1/online/current',
      method: 'get',
    },
  },
  fields: [

  ],
});
